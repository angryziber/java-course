<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output encoding="utf-8" />
	<xsl:template match="/">
		<html lang="en" xml:lang="en"
			xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<meta http-equiv="content-type"
					content="application/xhtml+xml; charset=UTF-8" />
				<title>Processed results</title>
			</head>
			<body>
					<table border="1">
						<tr>
							<th>Rank</th>
							<th>Points</th>
							<th>Name</th>
							<th>Date of birth</th>
							<th>Country code</th>
							<th>Sprint 100m (sec)</th>
							<th>Long jump (m)</th>
							<th>Shot put (m)</th>
							<th>High jump (m)</th>
							<th>Sprint 400m (mm:sec)</th>
							<th>Hurdles 110m (sec)</th>
							<th>Discus throw (m)</th>
							<th>Pole vault (m)</th>
							<th>Javelin throw (m)</th>
							<th>Race 1500m (mm:sec)</th>
						</tr>
						<xsl:for-each select="/ranks/rank">
							<tr>
								<td>
									<xsl:value-of select="@place" />
									<xsl:if test="@sharedPlace">
										-
										<xsl:value-of
											select="@sharedPlace" />
									</xsl:if>
								</td>
								<td>
									<xsl:value-of select="@points" />
								</td>
								<td>
									<xsl:value-of
										select="athlete/@name" />
								</td>
								<td>
									<xsl:value-of
										select="athlete/@birthDate" />
								</td>
								<td>
									<xsl:value-of
										select="athlete/@countryCode" />
								</td>
								<td>
									<xsl:value-of
										select="results/sprint100" />
								</td>
								<td>
									<xsl:value-of
										select="results/longJump" />
								</td>
								<td>
									<xsl:value-of
										select="results/shotPut" />
								</td>
								<td>
									<xsl:value-of
										select="results/highJump" />
								</td>
								<td>
									<xsl:value-of
										select="results/sprint400" />
								</td>
								<td>
									<xsl:value-of
										select="results/hurdles110" />
								</td>
								<td>
									<xsl:value-of
										select="results/discusThrow" />
								</td>
								<td>
									<xsl:value-of
										select="results/poleVault" />
								</td>
								<td>
									<xsl:value-of
										select="results/javelinThrow" />
								</td>
								<td>
									<xsl:value-of
										select="results/race1500" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>
