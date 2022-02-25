// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.AddressableLED;
// import edu.wpi.first.wpilibj.AddressableLEDBuffer;

// public class LEDLights {

// private double red;
// private double green;
// private double blue;

// private double angle = 0;



//     if (angle < 60) {
//         red = 255; green = (int)Math.round(angle * 4.25-0.01); blue = 0;
      
//       } else if (angle < 120) {
//         red = (int)Math.round((120 - angle) * 4.25 - 0.01); green = 255; blue = 0;
    
//       } else if (angle < 180) {
//         red = 0; green = 255; blue = (int)Math.round((angle - 120) * 4.25 - 0.01);
    
//       } else  if (angle < 240) {
//         red = 0; green = (int)Math.round((240 - angle) * 4.25 - 0.01); blue = 255;
    
//       } else if (angle < 300) {
//         red = (int)Math.round((angle - 240) * 4.25 - 0.01); green = 0; blue = 255;
    
//       } else  {
//         red = 255; green = 0; blue = (int)Math.round((360 - angle) * 4.25 - 0.01);
//       } 
    
     
//       m_LedBuffer.setRGB(0, red, green, blue) 
//       ;m_LedBuffer.setRGB(1, red, green, blue) 
//       ;m_LedBuffer.setRGB(2, red, green, blue) 
//       ;m_LedBuffer.setRGB(3, red, green, blue) 
//       ;m_LedBuffer.setRGB(4, red, green, blue) 
//       ;m_LedBuffer.setRGB(5, red, green, blue) 
//       ;m_LedBuffer.setRGB(6, red, green, blue) 
//       ;m_LedBuffer.setRGB(7, red, green, blue) 
//       ;m_LedBuffer.setRGB(8, red, green, blue)
//       ;m_LedBuffer.setRGB(9, red, green, blue) 
//       ;m_LedBuffer.setRGB(10, red, green, blue)  
//       ;m_LedBuffer.setRGB(11, red, green, blue)
//       ;m_LedBuffer.setRGB(12, red, green, blue)
//       ;m_LedBuffer.setRGB(13, red, green, blue)
//       ;m_LedBuffer.setRGB(14, red, green, blue)
//       ;m_LedBuffer.setRGB(15, red, green, blue)
//       ;m_LedBuffer.setRGB(16, red, green, blue)
//       ;m_LedBuffer.setRGB(17, red, green, blue)
//       ;m_LedBuffer.setRGB(18, red, green, blue)
//       ;m_LedBuffer.setRGB(19, red, green, blue)
//       ;m_LedBuffer.setRGB(20, red, green, blue)
//       ;m_LedBuffer.setRGB(21, red, green, blue)
//       ;m_LedBuffer.setRGB(22, red, green, blue)
//       ;m_LedBuffer.setRGB(23, red, green, blue)
//       ;m_LedBuffer.setRGB(24, red, green, blue)
//       ;m_LedBuffer.setRGB(25, red, green, blue)
//       ;m_LedBuffer.setRGB(26, red, green, blue)
//       ;m_LedBuffer.setRGB(27, red, green, blue)
//       ;m_LedBuffer.setRGB(28, red, green, blue)
//       ;m_LedBuffer.setRGB(29, red, green, blue)
//       ;m_LedBuffer.setRGB(30, red, green, blue)
//       ;m_LedBuffer.setRGB(31, red, green, blue)
//       ;m_LedBuffer.setRGB(32, red, green, blue)
//       ;m_LedBuffer.setRGB(33, red, green, blue)
//       ;m_LedBuffer.setRGB(34, red, green, blue)
//       ;m_LedBuffer.setRGB(35, red, green, blue)
//       ;m_LedBuffer.setRGB(36, red, green, blue)
//       ;m_LedBuffer.setRGB(37, red, green, blue)
//       ;m_LedBuffer.setRGB(38, red, green, blue)
//       ;m_LedBuffer.setRGB(39, red, green, blue)
//       ;m_LedBuffer.setRGB(40, red, green, blue)
//       ;m_LedBuffer.setRGB(41, red, green, blue)
//       ;m_LedBuffer.setRGB(42, red, green, blue)
//       ;m_LedBuffer.setRGB(43, red, green, blue)
//       ;m_LedBuffer.setRGB(44, red, green, blue)
//       ;m_LedBuffer.setRGB(45, red, green, blue)
//       ;m_LedBuffer.setRGB(46, red, green, blue)
//       ;m_LedBuffer.setRGB(47, red, green, blue)
//       ;m_LedBuffer.setRGB(48, red, green, blue)
//       ;m_LedBuffer.setRGB(49, red, green, blue)
//       ;m_LedBuffer.setRGB(50, red, green, blue)
//       ;m_LedBuffer.setRGB(51, red, green, blue)
//       ;m_LedBuffer.setRGB(52, red, green, blue)
//       ;m_LedBuffer.setRGB(53, red, green, blue)
//       ;m_LedBuffer.setRGB(54, red, green, blue)
//       ;m_LedBuffer.setRGB(55, red, green, blue)
//       ;m_LedBuffer.setRGB(56, red, green, blue)
//       ;m_LedBuffer.setRGB(57, red, green, blue)
//       ;m_LedBuffer.setRGB(58, red, green, blue)
//       ;m_LedBuffer.setRGB(59, red, green, blue)
//       ;m_LedBuffer.setRGB(60, red, green, blue)
//       ;m_LedBuffer.setRGB(61, red, green, blue)
//       ;m_LedBuffer.setRGB(62, red, green, blue)
//       ;m_LedBuffer.setRGB(63, red, green, blue)
//       ;m_LedBuffer.setRGB(64, red, green, blue)
//       ;m_LedBuffer.setRGB(65, red, green, blue)
//       ;m_LedBuffer.setRGB(66, red, green, blue)
//       ;m_LedBuffer.setRGB(67, red, green, blue)
//       ;m_LedBuffer.setRGB(68, red, green, blue)
//       ;m_LedBuffer.setRGB(69, red, green, blue)
//       ;m_LedBuffer.setRGB(70, red, green, blue)
//       ;m_LedBuffer.setRGB(71, red, green, blue)
//       ;m_LedBuffer.setRGB(72, red, green, blue)
//       ;m_LedBuffer.setRGB(73, red, green, blue)
//       ;m_LedBuffer.setRGB(74, red, green, blue)
//       ;m_LedBuffer.setRGB(75, red, green, blue)
//       ;m_LedBuffer.setRGB(76, red, green, blue)
//       ;m_LedBuffer.setRGB(77, red, green, blue)
//       ;m_LedBuffer.setRGB(78, red, green, blue)
//       ;m_LedBuffer.setRGB(79, red, green, blue)
//       ;m_LedBuffer.setRGB(80, red, green, blue)
//       ;m_LedBuffer.setRGB(81, red, green, blue)
//       ;m_LedBuffer.setRGB(82, red, green, blue)
//       ;m_LedBuffer.setRGB(83, red, green, blue)
//       ;m_LedBuffer.setRGB(84, red, green, blue)
//       ;m_LedBuffer.setRGB(85, red, green, blue)
//       ;m_LedBuffer.setRGB(86, red, green, blue)
//       ;m_LedBuffer.setRGB(87, red, green, blue)
//       ;m_LedBuffer.setRGB(88, red, green, blue)
//       ;m_LedBuffer.setRGB(89, red, green, blue)
//       ;m_LedBuffer.setRGB(90, red, green, blue)
//       ;m_LedBuffer.setRGB(91, red, green, blue)
//       ;m_LedBuffer.setRGB(92, red, green, blue)
//       ;m_LedBuffer.setRGB(93, red, green, blue)
//       ;m_LedBuffer.setRGB(94, red, green, blue)
//       ;m_LedBuffer.setRGB(95, red, green, blue)
//       ;m_LedBuffer.setRGB(96, red, green, blue)
//       ;m_LedBuffer.setRGB(97, red, green, blue)
//       ;m_LedBuffer.setRGB(98, red, green, blue)
//       ;m_LedBuffer.setRGB(99, red, green, blue)
//       ;m_LedBuffer.setRGB(100, red, green, blue)
//       ;m_LedBuffer.setRGB(101, red, green, blue)
//       ;m_LedBuffer.setRGB(102, red, green, blue)
//       ;m_LedBuffer.setRGB(103, red, green, blue)
//       ;m_LedBuffer.setRGB(104, red, green, blue)
//       ;m_LedBuffer.setRGB(105, red, green, blue)
//       ;m_LedBuffer.setRGB(106, red, green, blue)
//       ;m_LedBuffer.setRGB(107, red, green, blue)
//       ;m_LedBuffer.setRGB(108, red, green, blue)
//       ;m_LedBuffer.setRGB(109, red, green, blue)
//       ;m_LedBuffer.setRGB(110, red, green, blue)
//       ;m_LedBuffer.setRGB(111, red, green, blue)
//       ;m_LedBuffer.setRGB(112, red, green, blue)
//       ;m_LedBuffer.setRGB(113, red, green, blue)
//       ;m_LedBuffer.setRGB(114, red, green, blue)
//       ;m_LedBuffer.setRGB(115, red, green, blue)
//       ;m_LedBuffer.setRGB(116, red, green, blue)
//       ;m_LedBuffer.setRGB(117, red, green, blue)
//       ;m_LedBuffer.setRGB(118, red, green, blue)
//       ;m_LedBuffer.setRGB(119, red, green, blue)
//       ;m_LedBuffer.setRGB(120, red, green, blue)
//       ;m_LedBuffer.setRGB(121, red, green, blue)
//       ;m_LedBuffer.setRGB(122, red, green, blue)
//       ;m_LedBuffer.setRGB(123, red, green, blue)
//       ;m_LedBuffer.setRGB(124, red, green, blue)
//       ;m_LedBuffer.setRGB(125, red, green, blue)
//       ;m_LedBuffer.setRGB(126, red, green, blue)
//       ;m_LedBuffer.setRGB(127, red, green, blue)
//       ;m_LedBuffer.setRGB(128, red, green, blue)
//       ;m_LedBuffer.setRGB(129, red, green, blue)
//       ;m_LedBuffer.setRGB(130, red, green, blue)
//       ;m_LedBuffer.setRGB(131, red, green, blue)
//       ;m_LedBuffer.setRGB(132, red, green, blue)
//       ;m_LedBuffer.setRGB(133, red, green, blue)
//       ;m_LedBuffer.setRGB(134, red, green, blue)
//       ;m_LedBuffer.setRGB(135, red, green, blue)
//       ;m_LedBuffer.setRGB(136, red, green, blue)
//       ;m_LedBuffer.setRGB(137, red, green, blue)
//       ;m_LedBuffer.setRGB(138, red, green, blue)
//       ;m_LedBuffer.setRGB(139, red, green, blue)
//       ;m_LedBuffer.setRGB(140, red, green, blue)
//       ;m_LedBuffer.setRGB(141, red, green, blue)
//       ;m_LedBuffer.setRGB(142, red, green, blue)
//       ;m_LedBuffer.setRGB(143, red, green, blue)
//       ;m_LedBuffer.setRGB(144, red, green, blue)
//       ;m_LedBuffer.setRGB(145, red, green, blue)
//       ;m_LedBuffer.setRGB(146, red, green, blue)
//       ;m_LedBuffer.setRGB(147, red, green, blue)
//       ;m_LedBuffer.setRGB(148, red, green, blue)
//       ;m_LedBuffer.setRGB(149, red, green, blue)
//       ;
    
    
//       m_led.setData(m_LedBuffer);
    
//       SmartDashboard.putNumber("red", red)
//     ;  SmartDashboard.putNumber("green", green)
//     ;  SmartDashboard.putNumber("blue", blue)
//     ;
// }
