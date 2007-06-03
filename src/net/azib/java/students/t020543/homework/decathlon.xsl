<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/">
	<html>
	<body>
		<xsl:for-each select="//Athlete">
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</body>
	</html>
</xsl:template>

<xsl:template match="Athlete">
	<br/>
	Place: <xsl:value-of select="place"/>
	<br/>
	Score: <xsl:value-of select="score"/>
	<br/>
	Name:  <xsl:value-of select="name"/>
	<br/>
	Birthday: <xsl:value-of select="birthday"/>
	<br/>
	Country: <xsl:value-of select="country"/>
	<br/>
	Sprint 100m: <xsl:value-of select="sprint100"/>
	<br/>
	Long Jump: <xsl:value-of select="longJump"/>
	<br/>
	Shot put: <xsl:value-of select="shotPut"/>
	<br/>
	High Jump: <xsl:value-of select="highJump"/>
	<br/>
	Sprint 400m: <xsl:value-of select="sprint400"/>
	<br/>
	Hurdles 110m: <xsl:value-of select="hurdles110"/>
	<br/>
	Discus Throw: <xsl:value-of select="discusThrow"/>
	<br/>
	Pole Vault: <xsl:value-of select="poleVault"/>
	<br/>
	Javelin Throw: <xsl:value-of select="javelinThrow"/>
	<br/>
	Race 1500m: <xsl:value-of select="race1500"/>
	<br/>
	<br/>
</xsl:template>

</xsl:stylesheet>