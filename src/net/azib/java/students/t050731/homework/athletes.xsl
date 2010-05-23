<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/DecathlonResults">
	<html>
	<body>
		<xsl:apply-templates/>
	</body>
	</html>
</xsl:template>

<xsl:template match="Athlete">
	<p>
		<i><b><xsl:value-of select="Name"/></b></i>
		<br/>Birthdate: <b><xsl:value-of select="Birthdate"/></b>
		<br/>Country: <b><xsl:value-of select="Country"/></b>
		<br/>Short sprint result: <b><xsl:value-of select="ShortSprintResult"/></b>
		<br/>Longjump result: <b><xsl:value-of select="LongJumpResult"/></b>
		<br/>Shot put result: <b><xsl:value-of select="ShotPutResult"/></b>
		<br/>High jump result: <b><xsl:value-of select="HighJumpResult"/></b>
		<br/>Long sprint result: <b><xsl:value-of select="LongSprintResult"/></b>
		<br/>Hurdles result: <b><xsl:value-of select="HurdlesResult"/></b>
		<br/>Discus throw result: <b><xsl:value-of select="DiscusThrowResult"/></b>
		<br/>Pole vault result: <b><xsl:value-of select="PoleVaultResult"/></b>
		<br/>Javelin throw result: <b><xsl:value-of select="JavelinThrowResult"/></b>
		<br/>Race result: <b><xsl:value-of select="RaceResult"/></b>
		<br/>Total score: <b><xsl:value-of select="TotalScore"/></b>
		<br/>Position: <b><xsl:value-of select="Position"/></b>

	</p>
</xsl:template>

</xsl:stylesheet>

