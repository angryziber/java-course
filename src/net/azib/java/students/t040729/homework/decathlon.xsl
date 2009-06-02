<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/decathlon">
		<html>
		<head>
		<title>Decathlon competition results</title>
		</head>
			<body>
				<table cellpadding="3" cellspacing="0" border="1">
					<tr style="background-color: #afa; text-align: center">
						<td rowspan="2">Place</td>
						<td rowspan="2">Points</td>
						<td rowspan="2" style="text-align: center">Name</td>
						<td rowspan="2">Birthdate</td>
						<td rowspan="2">Country</td>
						<td colspan="5" style="background-color: #ffa; text-align: center">Day 1</td>
						<td colspan="5" style="background-color: #ffa; text-align: center">Day 2</td>
					</tr>
					<tr style="background-color: #afa; text-align: center">
						<td>100 meters</td>
						<td>Long Jump</td>
						<td>Shot Put</td>
						<td>High Jump</td>
						<td>400 meters</td>
						<td>110 meter hurdles</td>
						<td>Discus throw</td>
						<td>Pole Vault</td>
						<td>Javelin throw</td>
						<td>1500 meters</td>
					</tr>
					<xsl:apply-templates />
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="athlete">

		<tr style="background-color: #ddf; text-align: right">
			<td>
				<xsl:value-of select="@place" />
			</td>
			<td>
				<xsl:value-of select="@points" />
			</td>
			<td style="text-align: left">
				<xsl:value-of select="name" />
			</td>
			<td>
				<xsl:value-of select="birthdate" />
			</td>
			<td>
				<xsl:value-of select="@country" />
			</td>
			<td>
				<xsl:value-of select="results/e_100_m" />
			</td>
			<td>
				<xsl:value-of select="results/e_long_jump" />
			</td>
			<td>
				<xsl:value-of select="results/e_shot_put" />
			</td>
			<td>
				<xsl:value-of select="results/e_high_jump" />
			</td>
			<td>
				<xsl:value-of select="results/e_400_m" />
			</td>
			<td>
				<xsl:value-of select="results/e_110_m_hurdles" />
			</td>
			<td>
				<xsl:value-of select="results/e_discus_throw" />
			</td>
			<td>
				<xsl:value-of select="results/e_pole_vault" />
			</td>
			<td>
				<xsl:value-of select="results/e_javelin_throw" />
			</td>
			<td>
				<xsl:value-of select="results/e_1500_m" />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>