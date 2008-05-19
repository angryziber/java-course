<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <html>
            <body>
                <h1>Results for the Decathlon Competition</h1>
                <xsl:choose>
                    <xsl:when test="string-length(.) > 0">
                        <xsl:for-each select="//athlete">
                            <xsl:apply-templates select="."/>
                        </xsl:for-each>
                    </xsl:when>
                    <xsl:otherwise>
                        <h2> No results found</h2>
                    </xsl:otherwise>
                </xsl:choose>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="athlete">
        <p>
            <h2>Place #<xsl:value-of select="place"/>:  <u><xsl:value-of select="results/@total_score"/></u> points</h2>
            <h3><xsl:apply-templates select="personal_data"/></h3>
        </p>
        <p><xsl:apply-templates select="results"/></p>
    </xsl:template>

    <xsl:template match="personal_data">
        <xsl:value-of select="name"/> (<xsl:value-of select="birth"/>, <xsl:value-of select="country"/>)
    </xsl:template>

    <xsl:template match="results">
        <table border="1">
            <tr>
                <xsl:for-each select="result">
                    <td align="center">
                        <h4>
                            <xsl:value-of select="@event"/>
                            <br/>
                            (<xsl:value-of select="@unit"/>)
                        </h4>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <xsl:for-each select="result">
                    <td align="center">
                        <xsl:value-of select="."/>
                    </td>
                </xsl:for-each>
            </tr>

        </table>
    </xsl:template>


</xsl:stylesheet>
