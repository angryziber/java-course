<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" indent="yes"/>
	<xsl:template match="/athletes">
		<html>
			<body>
				<table border="1">
					<xsl:apply-templates select="athlete"/>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="athlete">
		<tr>
			<td>
				<b>
					<xsl:value-of select="name"/>
				</b>
			</td>
			<td>
				<xsl:value-of select="country"/>
			</td>
			<td>
				<xsl:value-of select="date_of_birth"/>
			</td>
			<td>
				<xsl:value-of select="sprint_100"/>
			</td>
			<td>
				<xsl:value-of select="long_jump"/>
			</td>
			<td>
				<xsl:value-of select="shot_put"/>
			</td>
			<td>
				<xsl:value-of select="high_jump"/>
			</td>
			<td>
				<xsl:value-of select="sprint_400"/>
			</td>
			<td>
				<xsl:value-of select="hurdles_110"/>
			</td>
			<td>
				<xsl:value-of select="discus_throw"/>
			</td>
			<td>
				<xsl:value-of select="pole_vault"/>
			</td>
			<td>
				<xsl:value-of select="javelin_throw"/>
			</td>
			<td>
				<xsl:value-of select="race_1500"/>
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>