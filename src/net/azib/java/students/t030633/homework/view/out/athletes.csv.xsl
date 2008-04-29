<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" />

<!-- Athlete transformation from XML to text -->

<xsl:template match="/">

<xsl:for-each select="//athlete">

<xsl:value-of select="position()"/><xsl:text>,</xsl:text>

<xsl:for-each select="score">
<xsl:value-of select="."/><xsl:text>,</xsl:text>
</xsl:for-each>

<xsl:for-each select="name">
<xsl:value-of select="."/><xsl:text>,</xsl:text>
</xsl:for-each>

<xsl:for-each select="country">
<xsl:value-of select="."/><xsl:text>,</xsl:text>
</xsl:for-each>

<xsl:for-each select="birthdate">
<xsl:value-of select="."/><xsl:text>,</xsl:text>
</xsl:for-each>

<xsl:for-each select="results//performance">
<xsl:value-of select="."/>
<xsl:if test="position() != last()">,</xsl:if>
</xsl:for-each>

<xsl:text>;
</xsl:text>

</xsl:for-each>

</xsl:template>

</xsl:stylesheet>