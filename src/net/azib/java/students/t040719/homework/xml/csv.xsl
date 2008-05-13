<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" encoding="utf-8"/>
	<xsl:template match="/">Name,Place,Score,Birthday,Country code,100 m sprint,Long jump,Shot put,High jump,400 m sprint,110 m hurdles,Discus throw,Pole vault,Javelin throw,1500 m race<xsl:for-each select="decathlon/athlete">
"<xsl:value-of select="name"/>",<xsl:value-of select="place"/>,<xsl:value-of select="score"/>,<xsl:value-of select="birthday"/>,<xsl:value-of select="country/code"/>,<xsl:for-each select="event"><xsl:choose><xsl:when test="position() != last()"><xsl:value-of select="result"/>,</xsl:when><xsl:otherwise><xsl:value-of select="result"/></xsl:otherwise></xsl:choose></xsl:for-each></xsl:for-each>
	</xsl:template>
</xsl:stylesheet>