<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/Athletes">
	<html>
		<body>
			<table border="1">
				<xsl:apply-templates select="Athlete"/>
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="Athlete">
	<tr>
	    <td><b><xsl:value-of select="Name"/></b></td>
        <td><xsl:value-of select="BirthDay"/></td>
        <td><xsl:value-of select="Country"/></td>

        <td><xsl:value-of select="HundredMeterSprint"/></td>
        <td><xsl:value-of select="LongJump"/></td>
        <td><xsl:value-of select="ShotPut"/></td>
        <td><xsl:value-of select="HighJump"/></td>
        <td><xsl:value-of select="FourHundredMeterRace"/></td>
        <td><xsl:value-of select="HTMHurdles"/></td>
        <td><xsl:value-of select="DiscusThrow"/></td>
        <td><xsl:value-of select="PoleVault"/></td>
        <td><xsl:value-of select="JavelinThrow"/></td>
        <td><xsl:value-of select="KndHRace"/></td>


	</tr>
</xsl:template>

</xsl:stylesheet>
