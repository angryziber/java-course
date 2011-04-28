<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/bookstore">
	<html>
		<body>
			<table border="1">
				<xsl:apply-templates select="book"/>
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="book">
	<tr>
	    <td><b><xsl:value-of select="title"/></b></td>
	    <td>
		    <xsl:for-each select="author">
			    <xsl:value-of select="."/><br/>
		    </xsl:for-each>
	    </td>
		<td><xsl:value-of select="price"/></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
