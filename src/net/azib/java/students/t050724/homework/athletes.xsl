<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/Athletes">
	<html>
	<body>
		<xsl:apply-templates/>
	</body>
	</html>
</xsl:template>

<xsl:template match="Athlete">
	<p>
		<xsl:value-of select="Place"/>
		<br/><b><xsl:value-of select="Score"/></b>
		<br/><xsl:value-of select="Name"/>
		<br/><xsl:value-of select="Date"/>
		<br/><xsl:value-of select="Country"/>
		<br/><xsl:value-of select="Hm"/>
		<br/><xsl:value-of select="LongJump"/>
		<br/><xsl:value-of select="ShotPut"/>
		<br/><xsl:value-of select="HighJump"/>
		<br/><xsl:value-of select="Fhm"/>
		<br/><xsl:value-of select="HtmHurdles"/>
		<br/><xsl:value-of select="DiscusThrow"/>
		<br/><xsl:value-of select="PoleVault"/>
		<br/><xsl:value-of select="JavelinThrow"/>
		<br/><xsl:value-of select="Tfhm"/>
	</p>
</xsl:template>

</xsl:stylesheet>

