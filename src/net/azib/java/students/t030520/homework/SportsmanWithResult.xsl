<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<html>
			<head><title>Decathlon competition</title></head>
			<body>
				<table style="border: 1px solid #000000;" cellpadding="2px">
					<tr>
						<th style="border: 1px solid #000000;">Place</th>
						<th>Points</th>
						<th>Name</th>
						<th>Birthday</th>
						<th>Country code</th>
						<th>100 m sprint</th>
						<th>Long jump</th>
						<th>Shot put</th>
						<th>High jump</th>
						<th>400 m sprint</th>
						<th>110 m hurdles</th>
						<th>Discus throw</th>
						<th>Pole vault</th>
						<th>Javelin throw</th>
						<th>1500 m race</th>
					</tr>
					<xsl:for-each select="sportsmens/sportsmen">
						<tr>
							<td style="border: 1px solid #000000;"><xsl:value-of select="place"/></td>
							<td><xsl:value-of select="points"/></td>
							<td><xsl:value-of select="@name"/></td>
							<td><xsl:value-of select="@birthday"/></td>
							<td align="center"><xsl:value-of select="@countrycode"/></td>
							<td align="center"><xsl:value-of select="sprint100"/></td>
							<td align="center"><xsl:value-of select="longjump"/></td>
							<td align="center"><xsl:value-of select="shotput"/></td>
							<td align="center"><xsl:value-of select="highjump"/></td>
							<td align="center"><xsl:value-of select="sprint400"/></td>
							<td align="center"><xsl:value-of select="hurdles110"/></td>
							<td align="center"><xsl:value-of select="discusthrow"/></td>
							<td align="center"><xsl:value-of select="polevault"/></td>
							<td align="center"><xsl:value-of select="javelinthrow"/></td>
							<td align="center"><xsl:value-of select="race1500"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>