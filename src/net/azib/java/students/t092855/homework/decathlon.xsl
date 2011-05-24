<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/decathlonCompetition">
	<html>
		<body>
			<head>
				<meta hppt-equiv="content-type" content="text/html; charset=UTF-8"/>
					<title>Decathlon competition results</title>
			</head>
			<table border="1">
				<tr>
					<th>Rank</th>
					<th>Total Points</th>
					<th>Name</th>
					<th>Birthday</th>
					<th>Country</th>
					<th>100 metres (s)</th>
					<th>Long jump (m)</th>
					<th>Shot put (m)</th>
					<th>High jump (m)</th>
					<th>400 metres (s)</th>
					<th>110 metres hurdles (s)</th>
					<th>Discus throw (m)</th>
					<th>Pole vault (m)</th>
					<th>Javelin throw (m)</th>
					<th>1500 metres (s)</th>
				</tr>
				<xsl:apply-templates select="athlete"/>
			</table>
		</body>
	</html>
</xsl:template>


<xsl:template match="athlete">
	<tr>
	    <td><b><xsl:value-of select="rank"/></b></td>
	    <td><b><xsl:value-of select="totalPoints"/></b></td>
	    <td><b><xsl:value-of select="name"/></b></td>
	    <td><b><xsl:value-of select="birthday"/></b></td>
	    <td><b><xsl:value-of select="country"/></b></td>
	    <td><b><xsl:value-of select="results/race100m"/></b></td>
	    <td><b><xsl:value-of select="results/longJump"/></b></td>
	    <td><b><xsl:value-of select="results/shotPut"/></b></td>
	    <td><b><xsl:value-of select="results/highJump"/></b></td>
	    <td><b><xsl:value-of select="results/race400m"/></b></td>
	    <td><b><xsl:value-of select="results/hurdles110m"/></b></td>
	    <td><b><xsl:value-of select="results/discusThrow"/></b></td>
	    <td><b><xsl:value-of select="results/poleVault"/></b></td>
	    <td><b><xsl:value-of select="results/javelinThrow"/></b></td>
	    <td><b><xsl:value-of select="results/race1500m"/></b></td>
	</tr>
</xsl:template>

</xsl:stylesheet>



