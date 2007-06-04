<?xml version="1.0" encoding="ISO-8859-1" ?> 
 <html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
 <body style="font-family:Arial,helvetica,sans-serif;font-size:12pt; background-color:#EEEEEE">
 <xsl:for-each select="participators/participator">
 <div style="background-color:teal;color:white;padding:4px">
 <span style="font-weight:bold;color:white">
 	 <xsl:value-of select="@position" />. (<xsl:value-of select="@points" />) - 
  <xsl:value-of select="name" /> - 
  </span>
  <xsl:value-of select="birthdate" /> -  
  <xsl:value-of select="country" /> 
  </div>
 <div style="margin-left:20px;margin-bottom:1em;font-size:10pt">
  <xsl:value-of select="description" /> 
 <span style="font-style:italic">
  
  100m Sprint result: <xsl:value-of select="hundredmetersprint" />  <br />
  Long jump result: <xsl:value-of select="longjump" /><br />
	Shot put result: <xsl:value-of select="shotput" /><br />
	High jump result: <xsl:value-of select="highjump" /><br />
	400m run result: <xsl:value-of select="fourhundredmetersprint" /><br />
	110m hurles result:<xsl:value-of select="hurdles" /><br />
	Discus throw result: <xsl:value-of select="discusthrow" /><br />
	Pole Vault result:<xsl:value-of select="polevault" /><br />
	Javelin Throw Result: <xsl:value-of select="javelinthrow" /><br />
	1500m run result: <xsl:value-of select="longrun" />
	
	
	
	
	
	
	
	
  </span>
  </div>
  </xsl:for-each>
  </body>
  </html>