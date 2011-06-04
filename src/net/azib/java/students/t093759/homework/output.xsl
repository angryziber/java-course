<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes"/>

	<xsl:template match="/decathlon">
		<html>
			<head>
				<meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
			</head>
			<body>
				<table border="1">
					<tr>
						<th>Place</th>
						<th>Points</th>
						<th>Name</th>
						<th>Country ISO2 Letter Code</th>
						<th>Date of birth</th>
						<th>100 m sprint</th>
						<th>Long jump</th>
						<th>Shot put</th>
						<th>High jump</th>
						<th>400 m sprint</th>
						<th>110 m hurdles</th>
						<th>Discus throw</th>
						<th>Pole vault</th>
						<th>Javelin throw</th>
						<th>1500 m sprint</th>
					</tr>
					<xsl:for-each select="athlete">
						<tr>
							<td>
								<xsl:value-of select="place"/>
							</td>
							<td>
								<xsl:value-of select="points"/>
							</td>
							<td>
								<xsl:value-of select="name"/>
							</td>
							<td>
								<xsl:value-of select="countryISO2LetterCode"/>
							</td>
							<td>
								<xsl:value-of select="dateOfBirth"/>
							</td>
							<td>
								<xsl:value-of select="oneHundredMeterSprint"/>
							</td>
							<td>
								<xsl:value-of select="longJump"/>
							</td>
							<td>
								<xsl:value-of select="shotPut"/>
							</td>
							<td>
								<xsl:value-of select="highJump"/>
							</td>
							<td>
								<xsl:value-of select="fourHundredMeterSprint"/>
							</td>
							<td>
								<xsl:value-of select="oneHundredTenMeterHurdles"/>
							</td>
							<td>
								<xsl:value-of select="discusThrow"/>
							</td>
							<td>
								<xsl:value-of select="poleVault"/>
							</td>
							<td>
								<xsl:value-of select="javelinThrow"/>
							</td>
							<td>
								<xsl:value-of select="thousandFiveHundredMeterRace"/>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>


</xsl:stylesheet>