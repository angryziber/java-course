<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl=
"http://www.w3.org/1999/XSL/Transform" version=
"1.0">

<xsl:output method="html" indent="yes"/>

<xsl:template match="/">
  <html>
  <body>
   <xsl:apply-templates/>
  </body>
  </html>
</xsl:template>

<xsl:template match="/">
   <table border="2" width="80%">
        <tr>
		  	<th>Place</th>
			<th>TotalPoints</th>
			<th>Name</th>
			<th>Birthdate</th>
			<th>Country</th>
			<th>M100</th>
			<th>LongJump</th>
			<th>ShotPut</th>
			<th>HighJump</th>
			<th>M400</th>
			<th>M110Hurdles</th>
			<th>DiscusThrow</th>
			<th>PoleVault</th>
			<th>JavelinThrow</th>
			<th>M1500</th>
	</tr>
     <xsl:for-each select="Athletes/Athlete">
       <tr>
         <td>
           <i><xsl:value-of select="Place"/></i>
         </td>
         <td>
           <i><xsl:value-of select="TotalPoints"/></i>
         </td>
         <td>
           <i><xsl:value-of select="Name"/></i>
         </td>
         <td>
           <i><xsl:value-of select="Birthdate"/></i>
         </td>
         <td>
           <i><xsl:value-of select="Country"/></i>
         </td>
         <td>
           <i><xsl:value-of select="M100Result"/></i>
         </td>
         <td>
           <i><xsl:value-of select="LongJumpResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="ShotPutResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="HighJumpResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="M400Result"/></i>
         </td>
         <td>
           <i><xsl:value-of select="M110HurdlesResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="DiscusThrowResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="PoleVaultResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="JavelinThrowResult"/></i>
         </td>
         <td>
           <i><xsl:value-of select="M1500Result"/></i>
         </td>
        </tr>
      </xsl:for-each>
    </table>
  </xsl:template>
</xsl:stylesheet>