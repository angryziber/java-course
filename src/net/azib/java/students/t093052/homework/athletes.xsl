<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />

	<xsl:template match="/athletes">
		<html>
			<head>
				<style type="text/css">
					td {text-align: center}
 				</style>
			</head>

			<body>
				<table border="1" align="center">
					<tr>
						<td>Place</td>
						<td>Points</td>
						<td>Name</td>
						<td>Country</td>
						<td>Birthday</td>
						<td>Sprint(100m)</td>
						<td>Long Jump</td>
						<td>Shot Put</td>
						<td>High Jump</td>
						<td>Sprint(400m)</td>
						<td>Hurdles(110m)</td>
						<td>Discus Throw</td>
						<td>Pole Vault</td>
						<td>Javelin Throw</td>
						<td>Race(1500m)</td>
					</tr>
					<xsl:apply-templates />
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="athlete">
		<tr>
			<td>
				<b>
					<xsl:value-of select="place" />
				</b>
			</td>
			<td>
				<xsl:value-of select="points" />
			</td>
			<td>
				<xsl:value-of select="@name" />
			</td>
			<td>
				<xsl:value-of select="@country" />
			</td>
			<td>
				<xsl:value-of select="@dateOfBirth" />
			</td>
			<xsl:for-each select="results/*">
				<td>
					<xsl:value-of select="." />
				</td>
			</xsl:for-each>
		</tr>
	</xsl:template>


</xsl:stylesheet>
