<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Decathlon results</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Place</th>
      <th>Total score</th>
      <th>Name</th>
      <th>Date of birth</th>
      <th>Country</th>
      <th>100m sprint</th>
      <th>Long jump</th>
      <th>Shot put</th>
      <th>High jump</th>
      <th>400m sprint</th>
      <th>110m hurdles</th>
      <th>Discus throw</th>
      <th>Pole vault</th>
      <th>Javelin throw</th>
      <th>1500m race</th>
    </tr>
    <xsl:for-each select="decathlon/athlete">
    <tr>
      <td><xsl:value-of select="place"/></td>
      <td><xsl:value-of select="score"/></td>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="date_of_birth"/></td>
      <td><xsl:value-of select="country"/></td>
      <td><xsl:value-of select="sprint_100m"/></td>
      <td><xsl:value-of select="long_jump"/></td>
      <td><xsl:value-of select="shot_put"/></td>
      <td><xsl:value-of select="high_jump"/></td>
      <td><xsl:value-of select="sprint_400m"/></td>
      <td><xsl:value-of select="hurdles_110m"/></td>
      <td><xsl:value-of select="discus_throw"/></td>
      <td><xsl:value-of select="pole_vault"/></td>
      <td><xsl:value-of select="javelin_throw"/></td>
      <td><xsl:value-of select="race_1500m"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>