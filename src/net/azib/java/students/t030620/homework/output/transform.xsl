<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
    <title>Decathlon results</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

  </head>
  <body>
    <h2>Decathlon results</h2>
    <table border="1">
      <tr>
        <th>#</th>
        <th>Score</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Country code</th>
        <th>100 m sprint (sec)</th>
        <th>Long jump (m)</th>
        <th>Shot put (m)</th>
        <th>High jump (m)</th>
        <th>400 m sprint (min:sec)</th>
        <th>110 m hurdles (sec)</th>
        <th>Discus throw (m)</th>
        <th>Pole vault (m)</th>
        <th>Javelin throw (m)</th>
        <th>1500 m race (min:sec)</th>
      </tr>
      <xsl:for-each select="results/result">
        <tr>
          <td><xsl:value-of select="place"/></td>
          <td><xsl:value-of select="score"/></td>
          <td><xsl:value-of select="name"/></td>
          <td><xsl:value-of select="date"/></td>
          <td><xsl:value-of select="code"/></td>
          <td><xsl:value-of select="sprint_100"/></td>
          <td><xsl:value-of select="long_jump"/></td>
          <td><xsl:value-of select="shot_put"/></td>
          <td><xsl:value-of select="high_jump"/></td>
          <td><xsl:value-of select="sprint_400"/></td>
          <td><xsl:value-of select="hurdles"/></td>
          <td><xsl:value-of select="discus_throw"/></td>
          <td><xsl:value-of select="pole_vault"/></td>
          <td><xsl:value-of select="javelin_throw"/></td>
          <td><xsl:value-of select="race"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>