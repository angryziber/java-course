<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Place</th>
        <th>Name</th>
        <th>Dob</th>
        <th>Iso</th>
        <th>Points</th>
        <th>scoreData</th>
      </tr>
      <xsl:for-each select="scores/score">
      <tr>
        <td><xsl:value-of select="place"/></td>
        <td><xsl:value-of select="name"/></td>
        <td><xsl:value-of select="dob"/></td>
        <td><xsl:value-of select="iso"/></td>
        <td><xsl:value-of select="points"/></td>
        <td><xsl:value-of select="scoreData"/></td>
        
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
