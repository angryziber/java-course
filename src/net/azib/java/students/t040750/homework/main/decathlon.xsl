<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8"/>

<xsl:template match="/">
  <html>
  <body>
  <h2>Decathlon Data</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Position</th>
      <th>Name</th>
      <th>Birthday</th>
      <th>Nationality</th>
      <th>100m</th>
      <th>Long Jump</th>
      <th>Shot Put</th>
      <th>High Jump</th>
      <th>400m</th>
      <th>110m Hurdles</th>
      <th>Discus</th>
      <th>Pole Vault</th>
      <th>Javelin</th>
      <th>1500m</th>
      <th>Total</th>
    </tr>
    <xsl:for-each select="Decathlon/DecathlonData">
    <tr>
      <td><xsl:value-of select="Position"/></td>
      <td><xsl:value-of select="Athlete/Name"/></td>
      <td><xsl:value-of select="Athlete/Birthday"/></td>
      <td><xsl:value-of select="Athlete/Nationality"/></td>
      <td><xsl:value-of select="Result/Run100m"/></td>
      <td><xsl:value-of select="Result/LongJump"/></td>
      <td><xsl:value-of select="Result/ShotPut"/></td>
      <td><xsl:value-of select="Result/HighJump"/></td>
      <td><xsl:value-of select="Result/Run400m"/></td>
      <td><xsl:value-of select="Result/Hurdles110m"/></td>
      <td><xsl:value-of select="Result/Discus"/></td>
      <td><xsl:value-of select="Result/PoleVault"/></td>
      <td><xsl:value-of select="Result/Javelin"/></td>
      <td><xsl:value-of select="Result/Run1500m"/></td>
      <td><xsl:value-of select="TotalPoints"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>