<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"><xsl:template match="/">
 <html>
 <body>
   <h2>Decathlon</h2>
   <table border="1">
     <tr bgcolor="FFFFFF">
       <th>Position</th>
       <th>Name</th>
       <th>DateOfBirth</th>
       <th>Country</th>
       <th>Run100m</th>
       <th>LongJump</th>
       <th>ShotPut</th>
       <th>HighJump</th>
       <th>Run400m</th>
       <th>Hurdles110m</th>
       <th>DiscusThrow</th>
       <th>PoleVault</th>
       <th>JavelinThrow</th>
       <th>Run1500m</th>
       <th>Score</th>
     </tr>
     <xsl:for-each select="Sportsmen/Sportsman">
      <tr>
        <td><xsl:value-of select="Position"/></td>
        <td><xsl:value-of select="Name"/></td>
        <td><xsl:value-of select="Date-of-Birth"/></td>
        <td><xsl:value-of select="Country"/></td>
        <td><xsl:value-of select="Results/Run-100-m"/></td>
        <td><xsl:value-of select="Results/Long-jump"/></td>
        <td><xsl:value-of select="Results/Shot-put"/></td>
        <td><xsl:value-of select="Results/High-jump"/></td>
        <td><xsl:value-of select="Results/Run-400-m"/></td>
        <td><xsl:value-of select="Results/Hurdles"/></td>
        <td><xsl:value-of select="Results/Discus-throw"/></td>
        <td><xsl:value-of select="Results/Pole-vault"/></td>
        <td><xsl:value-of select="Results/Javelin-throw"/></td>
        <td><xsl:value-of select="Results/Run-1500-m"/></td>
        <td><xsl:value-of select="Overall-result"/></td>
      </tr>
      </xsl:for-each>
   </table>
 </body>
 </html>
</xsl:template></xsl:stylesheet>