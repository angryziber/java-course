<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="html" omit-xml-declaration="yes" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" indent="yes"/>

<xsl:template match="competition">
  <html xmlns="http://www.w3.org/1999/xhtml"><head><title>Decathlon results</title></head><body>
    <xsl:apply-templates/>
  </body></html>
</xsl:template>

<xsl:template match="result">
  <div>
  <h1><xsl:value-of select="pos"/>. <xsl:value-of select="athlete"/> (<xsl:value-of select="country"/>), <xsl:value-of select="dob"/></h1>
  <h2>Score:<xsl:value-of select="score" /></h2>
  <table border="0">
  <tr><td>Competition</td><td>Result</td></tr>
  <xsl:for-each select="event">
  <tr>
  <td><xsl:value-of select="name"/></td>
  <td><xsl:value-of select="performance"/></td>
  </tr>
  </xsl:for-each>
  </table>
  </div>
</xsl:template>

</xsl:stylesheet>