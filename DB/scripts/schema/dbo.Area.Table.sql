USE [BLOG]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 07-Apr-16 8:48:55 PM ******/
DROP TABLE [dbo].[Area]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 07-Apr-16 8:48:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Area](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO
