<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Decathlon Results</h2>
                <table border="1">
                    <tr bgcolor="#FFE87C">
                        <th>Place</th>
                        <th>Name</th>
                        <th>Total Score</th>
                        <xsl:for-each select="decathlon/sportsman[1]/participation/event">
                            <th>
                                <xsl:value-of select="@name"/>
                            </th>
                        </xsl:for-each>
                    </tr>
                    <xsl:for-each select="decathlon/sportsman">
                        <tr>
                            <td>
                                <xsl:value-of select="place"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="totalscore"/>
                            </td>
                            <xsl:for-each select="participation/event">
                                <td>
                                    <xsl:value-of select="points"/>
                                    <xsl:choose>
                                        <xsl:when test="points/@unit = 'seconds'">s</xsl:when>
                                        <xsl:otherwise>m</xsl:otherwise>
                                    </xsl:choose>
                                </td>
                            </xsl:for-each>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>