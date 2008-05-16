<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
 version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 xmlns="http://www.w3.org/1999/xhtml">
 
<xsl:output method="html"/>

<xsl:template match="competition">
        <html>
        <head> <title>Decathlon calculator output</title> </head>
        <body>
                <h1>Results of decathlon competition</h1>
                <table border="1" cellpadding="2" cellspacing="2">
					<tbody>					
						<tr style="font-weight: bold;">
							<td><xsl:text>Position</xsl:text></td>
							<td><xsl:text>Score</xsl:text></td>
					        <td><xsl:text>Name</xsl:text></td>
					        <td><xsl:text>Country</xsl:text></td>
					        <td><xsl:text>Birthday</xsl:text></td>
					        <td><xsl:text>100m</xsl:text></td>
					        <td><xsl:text>long jump</xsl:text></td>
					        <td><xsl:text>shot put</xsl:text></td>
					        <td><xsl:text>high jump</xsl:text></td>
					        <td><xsl:text>400m</xsl:text></td>
					        <td><xsl:text>110m hurdles</xsl:text></td>
					        <td><xsl:text>discus throw</xsl:text></td>
					        <td><xsl:text>pole vault</xsl:text></td>
					        <td><xsl:text>javlelin throw</xsl:text></td>
					        <td><xsl:text>1500m</xsl:text></td>
						</tr>
		                <xsl:apply-templates select="athlete">
    		            </xsl:apply-templates>
                	</tbody>
                </table>
        </body>
        </html>
</xsl:template>
 
<xsl:template match="athlete">
	<tr>
		<td><xsl:value-of select="position"/></td>
		<td><xsl:value-of select="score"/></td>
        <td><xsl:value-of select="name"/></td>
        <td><xsl:value-of select="country"/></td>
        <td><xsl:value-of select="dob"/></td>
        <td><xsl:value-of select="results/race_100m"/></td>
        <td><xsl:value-of select="results/long_jump"/></td>
        <td><xsl:value-of select="results/shot_put"/></td>
        <td><xsl:value-of select="results/high_jump"/></td>
        <td><xsl:value-of select="results/race_400m"/></td>
        <td><xsl:value-of select="results/hurdles_110m"/></td>
        <td><xsl:value-of select="results/discus_throw"/></td>
        <td><xsl:value-of select="results/pole_vault"/></td>
        <td><xsl:value-of select="results/javelin_throw"/></td>
        <td><xsl:value-of select="results/race_1500m"/></td>
    </tr>
</xsl:template>
 
</xsl:stylesheet>
