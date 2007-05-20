<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<body>
<h3>Decathlon event</h3>
<table border="1"><tr>
<th>Place</th>
<th>Score</th>
<th>Name</th>
<th>Date of Birth</th>
<th>Country</th>
<th>100m</th>
<th>Long Jump</th>
<th>Shot Put</th>
<th>High Jump</th>
<th>400m</th>
<th>110m Hurdles</th>
<th>Discus Throw</th>
<th>Pole Vault</th>
<th>Javelin Throw</th>
<th>1500m</th></tr>
<xsl:for-each select="decathlon_event/athlete"><tr>
<td><xsl:value-of select="place"/></td>
<td><xsl:value-of select="score"/></td>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="date_of_birth"/></td>
<td><xsl:value-of select="country"/></td>
<td><xsl:value-of select="r_100m"/></td>
<td><xsl:value-of select="long_jump"/></td>
<td><xsl:value-of select="shot_put"/></td>
<td><xsl:value-of select="high_jump"/></td>
<td><xsl:value-of select="r_400m"/></td>
<td><xsl:value-of select="r_110m"/></td>
<td><xsl:value-of select="discus_throw"/></td>
<td><xsl:value-of select="pole_vault"/></td>
<td><xsl:value-of select="javelin_throw"/></td>
<td><xsl:value-of select="r_1500m"/></td>
</tr>
</xsl:for-each>
</table></body></html>
</xsl:template>
</xsl:stylesheet>
