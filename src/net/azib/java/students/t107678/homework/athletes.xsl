<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<html>
<head><title>Decathlon Competition</title></head>
<body>
<table border="1">
<tr>
<th>Place</th>
<th>Score</th>
<th>Name</th>
<th>BirthDate</th>
<th>Country</th>
<th>100m Sprint</th>
<th>Long Jump</th>
<th>Shot Put</th>
<th>High Jump</th>
<th>400m Sprint</th>
<th>110m Hurdles</th>
<th>Discus Throw</th>
<th>Pole Vault</th>
<th>Javelin Throw</th>
<th>1500m Race</th>
</tr>
<xsl:for-each select="competition/athlete">
<tr>
<td><xsl:value-of select="place"/></td>
<td><xsl:value-of select="score"/></td>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="dob"/></td>
<td><xsl:value-of select="country_code"/></td>
<td><xsl:value-of select="HundredMeters/performance"/></td>
<td><xsl:value-of select="LongJump/performance"/></td>
<td><xsl:value-of select="ShotPut/performance"/></td>
<td><xsl:value-of select="HighJump/performance"/></td>
<td><xsl:value-of select="FourHundredMeters/performance"/></td>
<td><xsl:value-of select="OneHundredTenHurdlese/performance"/></td>
<td><xsl:value-of select="DiscusThrow/performance"/></td>
<td><xsl:value-of select="PoleVault/performance"/></td>
<td><xsl:value-of select="JavelinThrow/performance"/></td>
<td><xsl:value-of select="ThousandFiveHundredMeters/performance"/></td>
</tr>
</xsl:for-each>
</table>
</body></html>
</xsl:template>
</xsl:stylesheet>
