<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Decathlon competition results</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            </head>
            <body>
                <h2>Decathlon competition results</h2>
                <table border="1">
                    <tr bgcolor="#FF69B4">
                        <th>Place</th>
                        <th>Overall result</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Country</th>
                        <th>100 meters</th>
                        <th>Long jump</th>
                        <th>Shot put</th>
                        <th>High jump</th>
                        <th>400 meters</th>
                        <th>110 meters hurdles</th>
                        <th>Discus throw</th>
                        <th>Pole vault</th>
                        <th>Javelin throw</th>
                        <th>1500 meters</th>
                    </tr>

                    <xsl:for-each select="Decathlon/athlete">
                        <tr>
                            <td>
                                <xsl:value-of select="place"/>
                            </td>
                            <td>
                                <xsl:value-of select="overall_result"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="birthday"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                            <td>
                                <xsl:value-of select="M_100"/>
                            </td>
                            <td>
                                <xsl:value-of select="LONG_JUMP"/>
                            </td>
                            <td>
                                <xsl:value-of select="SHOT_PUT"/>
                            </td>
                            <td>
                                <xsl:value-of select="HIGH_JUMP"/>
                            </td>
                            <td>
                                <xsl:value-of select="M_400"/>
                            </td>
                            <td>
                                <xsl:value-of select="HURDLES_110"/>
                            </td>
                            <td>
                                <xsl:value-of select="DISCUS_THROW"/>
                            </td>
                            <td>
                                <xsl:value-of select="POLE_VAULT"/>
                            </td>
                            <td>
                                <xsl:value-of select="JAVELIN_THROW"/>
                            </td>
                            <td>
                                <xsl:value-of select="M_1500"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>