<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

	<xsl:template match="/">
		<html>
			<body>
				<head>
					<meta hppt-equiv="content-type" content="text/html; charset=UTF-8"/>
					<title>Decathlon competition results</title>
				</head>
			
				<h1>Decathlon competition results</h1>
				<table border="1" cellspacing="0">
					<tr>
						<th>Place</th>
						<th>Total score</th>
						<th>Name</th>
						<th>Birthday</th>
						<th>Country</th>
						<th>100m Sprint</th>
						<th>Long jump</th>
						<th>Shot put</th>
						<th>High jump</th>
						<th>400m Sprint</th>
						<th>110m Hurdles</th>
						<th>Discus throw</th>
						<th>Pole vault</th>
						<th>Javelin throw</th>
						<th>1500m Race</th>
					</tr>
					<xsl:for-each select="//athlete">
						<tr>
							<xsl:apply-templates select="."/>
						</tr>
					</xsl:for-each>
				</table>
				
			</body>
		</html>
	</xsl:template>

	<xsl:template match="athlete">
		<td><xsl:value-of select="place"/></td>
		<td><xsl:value-of select="totalScore"/></td>
		<td><xsl:value-of select="name"/></td>
		<td><xsl:value-of select="birthday"/></td>
		<td><xsl:value-of select="coutryCode"/></td>
		<td><xsl:value-of select="results/sprint100m"/></td>
		<td><xsl:value-of select="results/longJump"/></td>
		<td><xsl:value-of select="results/shotPut"/></td>
		<td><xsl:value-of select="results/highJump"/></td>
		<td><xsl:value-of select="results/sprint400m"/></td>
		<td><xsl:value-of select="results/hurdles110m"/></td>
		<td><xsl:value-of select="results/discusThrow"/></td>
		<td><xsl:value-of select="results/poleVault"/></td>
		<td><xsl:value-of select="results/javelinThrow"/></td>
		<td><xsl:value-of select="results/race1500m"/></td>
	</xsl:template>

</xsl:stylesheet>