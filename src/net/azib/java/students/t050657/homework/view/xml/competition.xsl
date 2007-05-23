<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/">
	<html>
	<body>
		<xsl:for-each select="//competition">
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</body>
	</html>
</xsl:template>

<xsl:template match="competition">
	<h2>
		<xsl:value-of select="@description"/> at 
		<xsl:value-of select="@date"/>,
		<xsl:value-of select="@countryCode"/>
	</h2>
	<table>
		<tr bgcolor="#D4C5BA" align="center">
        	<td>Name</td>
        	<td>Country</td>
        	<td>Place</td>
        	<td>Score</td>
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
		<xsl:for-each select="athlet">
			<tr bgcolor="#EFE7E2">
				<xsl:apply-templates select="."/>
			</tr>
		</xsl:for-each>
	</table>
</xsl:template>

<xsl:template match="athlet">
		<td><xsl:value-of select="@name"/></td>
		<td align="center"><xsl:value-of select="@countryCode"/></td>
		<td align="center"><xsl:value-of select="place"/></td>
		<td align="center"><xsl:value-of select="finalscore"/></td>
		<xsl:for-each select="event">
			<td align="center"><xsl:apply-templates select="."/></td>
		</xsl:for-each>
</xsl:template>

<xsl:template name="event">
	<xsl:apply-templates/>
</xsl:template>

</xsl:stylesheet>