<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>
<xsl:template match="/Decathlon">
	<html>
	<body>
		<xsl:apply-templates/>
	</body>
	</html>
</xsl:template>
<xsl:template match="athlete">
	<h1><xsl:value-of select="place"/>. Place:
	<xsl:value-of select="name"/> with
	<xsl:value-of select="points"/> points. <br/></h1>
	Date Of Birth: <b><xsl:value-of select="dateOfBirth"/></b><br/>
	Country: <b><xsl:value-of select="country"/></b><br/>
	100 m sprint result: <b><xsl:value-of select="resultOf100mSprint"/></b><br/>
	Long jump result: <b><xsl:value-of select="resultOfLongJump"/></b><br/>
	Shot put result: <b><xsl:value-of select="resultOfShotPut"/></b><br/>
	High jump result: <b><xsl:value-of select="resultOfHighJump"/></b><br/>
	400 m sprint result: <b><xsl:value-of select="resultOf400mSprint"/></b><br/>
	110 m hurdles result: <b><xsl:value-of select="resultOf110mHurdles"/></b><br/>
	Discus throw result: <b><xsl:value-of select="resultOfDiscusThrow"/></b><br/>
	Pole vault result: <b><xsl:value-of select="resultOfPoleVault"/></b><br/>
	Javelin throw result: <b><xsl:value-of select="resultOfJavelinThrow"/></b><br/>
	1500 m race result: <b><xsl:value-of select="resultOf1500mRace"/></b><br/>
</xsl:template>
</xsl:stylesheet>