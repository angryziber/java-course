<?xml version="1.0" ?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" indent="yes" /> 
<xsl:template match="/">
<html>
<head></head>
<body>
  <h1>Decathlon Points Caltulation results:</h1> 
<xsl:for-each select="//sportsman">
  <xsl:apply-templates select="." /> 
  </xsl:for-each>
  </body>
  </html>
  </xsl:template>
<xsl:template match="sportsman">
<p>
  <h3>Sportsman:
  <xsl:value-of select="name" /> 
   (
   <xsl:value-of select="birthDate" />
   ) 
   <xsl:value-of select="country" />
   </h3></p>
<p><h4>Place:
     <xsl:value-of select="place" />
     </h4> 
</p>
<p>
   <b>100 m sprint (sec):</b> 
   <xsl:value-of select="sprint100mEvent" />
   <br />
   <b>Long jump (m):</b> 
      <xsl:value-of select="longJumpEvent" />
   <br />
    <b>Shot put (m):</b> 
      <xsl:value-of select="shotPutEvent" />
   <br />
   <b>High jump (m):</b> 
      <xsl:value-of select="highJumpEvent" />
   <br />
   <b>400 m sprint (sec):</b> 
      <xsl:value-of select="sprint400mEvent" />
   <br />
   <b>110 m hurdles (sec):</b> 
      <xsl:value-of select="hurdles110mEvent" />
   <br />
   <b>Discus throw (m):</b> 
      <xsl:value-of select="discusThrowEvent" />
   <br />
   <b>Pole vault (m):</b> 
      <xsl:value-of select="poleVaultEvent" />
   <br />
   <b>Javelin throw (m):</b> 
      <xsl:value-of select="javelinThrowEvent" />
   <br />
   <b>1500 m race (sec):</b> 
      <xsl:value-of select="race1500mEvent" />
   <br />
   <b>Decathlon points:</b> 
      <xsl:value-of select="points" />
  </p>
  <hr /> 
</xsl:template>
</xsl:stylesheet>