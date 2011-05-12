<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>The results of decathlon competiton</title>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
				<link rel="stylesheet" type="text/css" href="styles.css" />
			</head>
			<body>
				<h1>
					<b>Competition</b>: <xsl:value-of select="//competition/name"/> / <xsl:value-of select="//competition/location"/>
				</h1>
				<table id="athletes">
				<colgroup>
					<col class="emphasis"/>
				</colgroup>
					<tbody>
						<tr>	
							<th scope="col">place</th>
							<th scope="col">points</th>
							<th scope="col">nation</th>
							<th scope="col">athlete</th>
							<th scope="col">100m <br /> (sec)</th>
							<th scope="col">long jump <br /> (m)</th>
							<th scope="col">shot put <br /> (m)</th>
							<th scope="col">high jump <br /> (m)</th>
							<th scope="col">400m <br /> (sec)</th>
							<th scope="col">110m hurdles <br /> (sec)</th>
							<th scope="col">discus throw <br /> (m)</th>
							<th scope="col">pole vault <br /> (m)</th>
							<th scope="col">javelin throw <br /> (m)</th>
							<th scope="col">1500m <br /> (sec)</th>
						</tr>
						<xsl:for-each select="/decathlon/competition/athletes/athlete">
							<xsl:sort select="score" order="descending"/>
							<tr>
								<td class="other"><xsl:value-of select="place"/></td>
								<td class="other"><xsl:value-of select="score"/></td>
								<td class="other"><xsl:value-of select="country_code"/></td>
								<td id="athlete_name"><xsl:value-of select="name"/></td>
								
								<xsl:for-each select="descendant::result">
									<td class="other"><xsl:value-of select="value"/></td>
								</xsl:for-each>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
