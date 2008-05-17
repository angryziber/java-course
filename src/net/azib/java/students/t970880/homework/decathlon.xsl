<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"
	            encoding="ISO-8859-1"
	            indent="yes"/>
	
	<xsl:template match="tourapment">
	<html>
		<body>
		
			<table>
				
				<thead>
				
					<th>place</th>
					<th>name</th>
					<th>score</th>
					<th>birthday</th>
					<th>country</th>
					<th>race_100m</th>
					<th>long_jump</th>
					<th>shot_put</th>
					<th>high_jump</th>
					<th>race_400m</th>
					<th>hurdles_110m</th>
					<th>discus_throw</th>
					<th>pole_vault</th>
					<th>javelin_throw</th>
					<th>race_1500m</th>
				
				</thead>
				<tbody>
						<xsl:apply-templates/>
				</tbody>
				
			</table>
		
		</body>
	</html>
	</xsl:template>
	
	
<xsl:template match="athlete">
	<tr>
		<td><xsl:value-of select="@place"/></td>
		<td><xsl:value-of select="@name"/></td>
		<td><xsl:value-of select="@score"/></td>
		<td><xsl:value-of select="@birthdate"/></td>
		<td><xsl:value-of select="@country"/></td>
						<xsl:apply-templates/>
	</tr>
</xsl:template>
<xsl:template match="result">
		<td><xsl:value-of select="."/></td>
</xsl:template>
</xsl:stylesheet>


