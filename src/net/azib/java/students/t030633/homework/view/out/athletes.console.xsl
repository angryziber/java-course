<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" />

<!-- Athlete transformation from XML to text -->

<xsl:template match="/">

<xsl:text>-=[Athletes]=-</xsl:text>
<xsl:apply-templates />

</xsl:template>

<xsl:template match="athlete">

<xsl:text>
Name: </xsl:text>
<xsl:value-of select="name" />
<xsl:text>
Country: </xsl:text>
<xsl:value-of select="country" />
<xsl:text>
Birth date: </xsl:text>
<xsl:value-of select="birthdate" />
<xsl:text>
Total score: </xsl:text>
<xsl:value-of select="score" />
<xsl:apply-templates select="results/result" />

</xsl:template>

<xsl:template match="result">
<xsl:text>
  </xsl:text>
<xsl:value-of select="event" />
<xsl:text> -- </xsl:text>
<xsl:value-of select="performance" /></xsl:template>

</xsl:stylesheet>