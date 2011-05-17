<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/decathlon">
	<html>
		<head>
			<title>Decathlon results</title>
			<style type="text/css">
				body {
					color: #663300;
					background-color: #F4E9DA
				}
				table {
					border: 1px solid gray;
					border-collapse: collapse;
				}
				th { background: #DCBA8B; }
			</style>
		</head>
		<body>
			<table border="1">
				<tr>
					<th>Position</th>
					<th>Score</th>
					<th>Name</th>
					<th>Country</th>
					<th>Birthday</th>
					<th>Sprint 100m</th>
					<th>Long jump</th>
					<th>Shot put</th>
					<th>High jump</th>
					<th>Sprint 400m</th>
					<th>Hurdles 110m</th>
					<th>Discus throw</th>
					<th>Pole vault</th>
					<th>Javelin throw</th>
					<th>Race 1500m</th>
				</tr>
				<xsl:apply-templates select="athlete"/>
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="athlete">
	<tr>
	    <th><xsl:value-of select="position"/></th>
		<td><xsl:value-of select="score"/></td>
		<td><xsl:value-of select="name"/></td>
		<td><xsl:value-of select="country"/></td>
		<td><xsl:value-of select="birthday"/></td>
		<xsl:for-each select="event">
			<td><xsl:value-of select="result"/></td>
		</xsl:for-each>
	</tr>
</xsl:template>

</xsl:stylesheet>
