<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<strong><xsl:output method="html" encoding="ISO-8859-1"/></strong>

<xsl:template match="/">
  <html>
  <body>
  <h2>Decathlon competition</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Position</th>
      <th>Score</th>
      <th>Name</th>
      <th>Birthdate</th>
      <th>Country</th>
      <th>Race 100m</th>
      <th>Shot put</th>
      <th>Long jump</th>
      <th>Javelin throw</th>
      <th>Pole vault</th>
      <th>High jump</th>
      <th>Hurdles 100m</th>
      <th>Race 400m</th>
      <th>Race 1500m</th>
      <th>Discus throw</th>
    </tr>
    <xsl:for-each select="Competition/Athlete">
    <tr>
      <td><xsl:value-of select="Position"/></td>
      <td><xsl:value-of select="Score"/></td>
      <td><xsl:value-of select="Name"/></td>
      <td><xsl:value-of select="Birthdate"/></td>
      <td><xsl:value-of select="Country"/></td>
      <td><xsl:value-of select="Events/RACE_100M"/></td>
      <td><xsl:value-of select="Events/SHOT_PUT"/></td>
      <td><xsl:value-of select="Events/LONG_JUMP"/></td>
      <td><xsl:value-of select="Events/JAVELIN_THROW"/></td>
      <td><xsl:value-of select="Events/POLE_VAULT"/></td>
      <td><xsl:value-of select="Events/HIGH_JUMP"/></td>
      <td><xsl:value-of select="Events/HURDLES_110M"/></td>
      <td><xsl:value-of select="Events/RACE_400M"/></td>
      <td><xsl:value-of select="Events/RACE_1500M"/></td>
      <td><xsl:value-of select="Events/DISCUS_THROW"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>