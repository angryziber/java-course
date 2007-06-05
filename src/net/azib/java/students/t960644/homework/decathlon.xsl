<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="//competition">
					<h2>Description: <xsl:value-of select="description"/></h2>
					<h2>Date: <xsl:value-of select="date"/></h2>
					<h2>Location: <xsl:value-of select="location"/> </h2>
                    <table border="1">
                        <tr>
                            <th>Position</th>
                            <th>Score</th>
                            <th>Name</th>
                            <th>Date of Birth</th>
                            <th>Country</th>
                            <th>Race 100m</th>
                            <th>Long Jump</th>
                            <th>Shot Put</th>
                            <th>High Jump</th>
                            <th>Race 400m</th>
                            <th>Hurdles 110m</th>
                            <th>Discus Throw</th>
                            <th>Pole Vault</th>
                            <th>Javelin Throw</th>
                            <th>Race 1500m</th>
                        </tr>
                        <xsl:apply-templates select="."/>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="result">
        <tr>
            <td>
                <xsl:value-of select="position"/>
            </td>
            <td>
                <xsl:value-of select="score"/>
            </td>
            <td>
                <xsl:value-of select="athlete"/>
            </td>
            <td>
                <xsl:value-of select="born"/>
            </td>
            <td>
                <xsl:value-of select="country"/>
            </td>
            <td>
                <xsl:value-of select="race-100m"/>
            </td>
            <td>
                <xsl:value-of select="long-jump"/>
            </td>
            <td>
                <xsl:value-of select="shot-put"/>
            </td>
            <td>
                <xsl:value-of select="high-jump"/>
            </td>
            <td>
                <xsl:value-of select="race-400m"/>
            </td>
            <td>
                <xsl:value-of select="hurdles-110m"/>
            </td>
            <td>
                <xsl:value-of select="discus-throw"/>
            </td>
            <td>
                <xsl:value-of select="pole-vault"/>
            </td>
            <td>
                <xsl:value-of select="javelin-throw"/>
            </td>
            <td>
                <xsl:value-of select="race-1500m"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
