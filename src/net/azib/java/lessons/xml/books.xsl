<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/bookstore">
	<html>
	<body>
		<xsl:apply-templates/>
	</body>
	</html>
</xsl:template>

<xsl:template match="book">
	<h1><xsl:value-of select="title"/></h1>
	Authors:<br/>
	<xsl:for-each select="author">
		<xsl:value-of select="."/><br/>	  
	</xsl:for-each>
	Year: <b><xsl:value-of select="year"/></b><br/>
	Price: <b>$<xsl:value-of select="price"/></b><br/>
	<xsl:if test="price > 100">
		<span style="color:red">Expensive!</span>
	</xsl:if>
</xsl:template>

</xsl:stylesheet>
