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
	<p>
		<b><xsl:value-of select="title"/></b>
		<xsl:for-each select="author">
			<br/><xsl:value-of select="."/>
		</xsl:for-each>
		<br/>
		Price: <span>
			<xsl:if test="price &lt; 30">
				<xsl:attribute name="style">color:red</xsl:attribute> 
			</xsl:if>
			$<xsl:value-of select="price"/>
		</span>
	</p>
</xsl:template>

</xsl:stylesheet>
