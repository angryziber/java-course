<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
		<html>
			<body>
				<h2>Decathlon Results</h2>
                <xsl:for-each select="//athlete">
					<h3><xsl:text>Name: </xsl:text><xsl:value-of select="name"/></h3>
                    <h3><xsl:text>Date of Birth: </xsl:text><xsl:value-of select="born"/></h3>
                    <h3><xsl:text>Country: </xsl:text><xsl:value-of select="country"/></h3>
					<h3><xsl:text>Total Score: </xsl:text><xsl:value-of select="points"/></h3>
					<h3><xsl:text>Place: </xsl:text><xsl:value-of select="place"/></h3>
					<h3><xsl:text>Events Results: </xsl:text></h3>
                    <table border="1">
						<tr bgcolor="#9acd32">
							<th>Name</th>
							<th>Result</th>
						</tr>
						<xsl:for-each select="events/event">
							<tr>
                                <td><xsl:value-of select="name" /></td>
								<td><xsl:value-of select="result" /></td>
							</tr>
						</xsl:for-each>
					</table>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>