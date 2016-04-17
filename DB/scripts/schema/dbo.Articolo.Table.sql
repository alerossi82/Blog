USE [BLOG]
GO
/****** Object:  Table [dbo].[Articolo]    Script Date: 07-Apr-16 8:48:55 PM ******/
DROP TABLE [dbo].[Articolo]
GO
/****** Object:  Table [dbo].[Articolo]    Script Date: 07-Apr-16 8:48:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Articolo](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ristorante] [nvarchar](50) NOT NULL,
	[IDArea] [nvarchar](50) NOT NULL,
	[IDCucina] [nvarchar](50) NOT NULL,
	[IDPrezzo] [nvarchar](50) NOT NULL,
	[Data] [date] NOT NULL,
	[Articolo] [nvarchar](max) NOT NULL,
	[IDVoto] [nvarchar](50) NOT NULL,
	[Foto] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
