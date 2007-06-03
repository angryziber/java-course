<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/">
	<html>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8" />
	<body>
	<table cellpadding="5" border="1">
		<tr>
			<td>Place</td>
			<td>Points</td>
			<td>Name</td>
			<td>Date of birth</td>
			<td>Country</td>
			<td>100 m sprint</td>
			<td>Long jump</td>
			<td>Shot put</td>
			<td>High jump</td>
			<td>400 m sprint</td>
			<td>110 m hurdles</td>
			<td>Discus throw</td>
			<td>Pole vault</td>
			<td>Javelin throw</td>
			<td>1500 m race</td>
		</tr>
		<xsl:for-each select="//participant">
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</table>
	</body>
	</html>
</xsl:template>

<xsl:template match="participant">
	<tr>
		<td>
			<xsl:value-of select="place"/>
		</td>
		<td>
			<xsl:value-of select="points"/>
		</td>
		<td>
			<xsl:value-of select="name"/>
		</td>
		<td>
			<xsl:value-of select="dateOfBirth"/>
		</td>
		<td>
			<xsl:value-of select="country"/>
		</td>
		<td>
			<xsl:value-of select="result0"/>
		</td>
		<td>
			<xsl:value-of select="result1"/>
		</td>
		<td>
			<xsl:value-of select="result2"/>
		</td>
		<td>
			<xsl:value-of select="result3"/>
		</td>
		<td>
			<xsl:value-of select="result4"/>
		</td>
		<td>
			<xsl:value-of select="result5"/>
		</td>
		<td>
			<xsl:value-of select="result6"/>
		</td>
		<td>
			<xsl:value-of select="result7"/>
		</td>
		<td>
			<xsl:value-of select="result8"/>
		</td>
		<td>
			<xsl:value-of select="result9"/>
		</td>
	</tr>
</xsl:template>

</xsl:stylesheet>
