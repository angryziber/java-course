<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="html" indent="yes"/>

<xsl:template match="/">
  <html>
  <body>
   <xsl:apply-templates/>
  </body>
  </html>
</xsl:template>

<xsl:template match="DecathlonCompetitionResults">
	<table border="2" width="50%">
	<tr>
        <td><i>AthletesName</i></td>
        <td><i>DateOfBirth</i></td>
        <td><i>Country</i></td>
        <td><i>Sprint100</i></td>
        <td><i>LongJump</i></td>
        <td><i>ShotPut</i></td>
        <td><i>HighJump</i></td>
        <td><i>Sprint400</i></td>
        <td><i>Hurdles110</i></td>
        <td><i>DiscusThrow</i></td>
        <td><i>PoleVault</i></td>
        <td><i>JavelinThrow</i></td>
        <td><i>Race1500</i></td>
        <td><i>Points</i></td>
	</tr>
	<xsl:for-each select="athlete">
	<tr>
		<td><i><xsl:value-of select="name"/></i></td>
		<td><xsl:value-of select="dob"/></td>
		<td><xsl:value-of select="country"/></td>
		<td><xsl:value-of select="sprint100"/></td>
		<td><xsl:value-of select="longJump"/></td>
		<td><xsl:value-of select="shotPut"/></td>
		<td><xsl:value-of select="highJump"/></td>
		<td><xsl:value-of select="sprint400"/></td>
		<td><xsl:value-of select="hurdles110"/></td>
		<td><xsl:value-of select="discusThrow"/></td>
		<td><xsl:value-of select="poleVault"/></td>
		<td><xsl:value-of select="javelinThrow"/></td>
		<td><xsl:value-of select="race1500"/></td>
		<td><xsl:value-of select="points"/></td>
	</tr>
	</xsl:for-each>
	</table>
	</xsl:template>
</xsl:stylesheet>