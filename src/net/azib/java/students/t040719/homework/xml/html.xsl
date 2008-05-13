<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="xml" indent="yes"
		media-type="text/html" encoding="utf-8" 
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" 
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" />
	<xsl:template match="/">
		<html>
			<head>
				<title>Decathlon results</title>
				<meta http-equiv="content-type" content="text/html;charset=utf-8" />
  				<meta http-equiv="Content-Style-Type" content="text/css" />
			</head>
  			<body>
    			<h2>Decathlon results</h2>
    			<table style="border: 1px solid grey">
			    	<tr style="background-color:#9acd32">
						<th>Place</th>
						<th>Score</th>
			        	<th>Name</th>
						<th>Birthday</th>
						<th>Country code</th>
						<th>Country name</th>
						<th><xsl:value-of select="decathlon/athlete/event[1]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[1]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[2]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[2]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[3]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[3]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[4]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[4]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[5]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[5]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[6]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[6]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[7]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[7]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[8]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[8]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[9]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[9]/unit"/>)</th>
						<th><xsl:value-of select="decathlon/athlete/event[10]/name"/><br/>(<xsl:value-of select="decathlon/athlete/event[10]/unit"/>)</th>
					</tr>
					<xsl:for-each select="decathlon/athlete">
						<tr>
							<xsl:attribute name="style"><xsl:if test="position() mod 2 = 0">background-color:#eeeee0;</xsl:if>
							</xsl:attribute>
							<td style="text-align:center; color:red; font-weight:bold"><xsl:value-of select="place"/></td>
							<td style="text-align:center; color:blue;"><xsl:value-of select="score"/></td>
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="birthday"/></td>
							<td style="text-align:center;"><xsl:value-of select="country/code"/></td>
							<td><xsl:value-of select="country/name"/></td>
							<xsl:for-each select="event">
								<td style="text-align:center;"><xsl:value-of select="result"/></td>
							</xsl:for-each>
						</tr>
					</xsl:for-each>
				</table>
			</body>
  		</html>
	</xsl:template>
</xsl:stylesheet>
