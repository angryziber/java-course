<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/">
	<html>
	<body>
		<h1>Our books</h1>
		<xsl:for-each select="//book">
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</body>
	</html>
</xsl:template>

<xsl:template match="book">
	<p>Title: <xsl:value-of select="title"/> - $<xsl:value-of select="price"/></p>
	<p>Year: <xsl:value-of select="year"/></p>
	<p>
		Authors:
		<xsl:for-each select="author">
			<xsl:value-of select="."/>
			<xsl:if test="position() != last()">, </xsl:if>
		</xsl:for-each> 
	</p>
	<hr/>
</xsl:template>

</xsl:stylesheet>
