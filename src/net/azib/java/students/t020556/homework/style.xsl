<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/DecathlonResults">
        <html>
            <body>
                <h2>Competitors</h2>
                <table border="1">
                    <tr bgcolor="#c0c0c0">
                        <td>Place</td>
                        <td>Name</td>
                        <td>Date of birth</td>
                        <td>Country</td>
                        <td>Score</td>
                        <td>100m race</td>
                        <td>long jump</td>
                        <td>shot put</td>
                        <td>high jump</td>
                        <td>400m race</td>
                        <td>110m hurdles</td>
                        <td>discus throw</td>
                        <td>pole vault</td>
                        <td>javelin throw</td>
                        <td>1500m race</td>
                    </tr>
                    <xsl:for-each select="Competitor">
                    <tr>
                        <td><xsl:value-of select="Place" /></td>
                        <td><xsl:value-of select="Name" /></td>
                        <td><xsl:value-of select="DateOfBirth" /></td>
                        <td><xsl:value-of select="Country" /></td>
                        <td><xsl:value-of select="Score" /></td>
                        <td><xsl:value-of select="RACE_100M" /></td>
                        <td><xsl:value-of select="LONG_JUMP" /></td>
                        <td><xsl:value-of select="SHOT_PUT" /></td>
                        <td><xsl:value-of select="HIGH_JUMP" /></td>
                        <td><xsl:value-of select="RACE_400M" /></td>
                        <td><xsl:value-of select="HURDLES_110M" /></td>
                        <td><xsl:value-of select="DISCUS_THROW" /></td>
                        <td><xsl:value-of select="POLE_VAULT" /></td>
                        <td><xsl:value-of select="JAVELIN_THROW" /></td>
                        <td><xsl:value-of select="RACE_1500M" /></td>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
