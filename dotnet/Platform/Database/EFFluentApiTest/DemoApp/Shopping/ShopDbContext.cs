global using Microsoft.EntityFrameworkCore;

namespace DemoApp.Shopping;

public class ShopDbContext : DbContext
{
    public DbSet<Product> Products { get; set; }

    public DbSet<Order> Orders { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=(localdb)\\METIIT;Database=Shop");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Product>()
            .ToTable("ProductInfo")
            .Property(p => p.Id)
            .HasColumnName("ProductNo");
        modelBuilder.Entity<Order>()
            .ToTable("OrderDetail")
            .Property(p => p.Id)
            .HasColumnName("OrderNo");
        modelBuilder.Entity<Order>()
            .Property(p => p.ProductId)
            .HasColumnName("ProductNo");
    }
}