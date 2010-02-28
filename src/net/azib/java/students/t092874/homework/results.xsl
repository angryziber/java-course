<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
version="1.0">
<xsl:template match="/">
<html>
<head><title>List of athlete's results</title></head>
<body>
<table border="1">
<tr>
<th>Place</th>
<th>Points</th>
<th>Name</th>
<th>Birthday</th>
<th>Country</th>
<th>Sprint 100</th>
<th>Long jump</th>
<th>Short put</th>
<th>High jump</th>
<th>Sprint 400</th>
<th>Discus throw</th>
<th>Pole vault</th>
<th>Javelin throw</th>
<th>Race 1500</th>
</tr>
<xsl:for-each select="results/athlete">
<tr>
<td><xsl:value-of select="place"/></td>
<td><xsl:value-of select="points"/></td>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="birthday"/></td>
<td><xsl:value-of select="country"/></td>

<xsl:for-each select="result">

<td><xsl:value-of select="sprint_100"/></td>
<td><xsl:value-of select="long_jump"/></td>
<td><xsl:value-of select="short_put"/></td>
<td><xsl:value-of select="high_jump"/></td>
<td><xsl:value-of select="sprint_400"/></td>
<td><xsl:value-of select="discus_throw"/></td>
<td><xsl:value-of select="pole_vault"/></td>
<td><xsl:value-of select="javelin_throw"/></td>
<td><xsl:value-of select="race_1500"/></td>

</xsl:for-each>
</tr>
</xsl:for-each>
</table>
</body></html>
</xsl:template>
</xsl:stylesheet>

