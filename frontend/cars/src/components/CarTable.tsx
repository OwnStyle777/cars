import type { CarDto } from "@/api";
import { flexRender, getCoreRowModel, getPaginationRowModel, useReactTable, type ColumnDef } from "@tanstack/react-table";
import { use, useMemo, useState } from "react";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/table";
import { Button } from "./ui/button";

type CarTableProps = {
    cars: CarDto[],
}

export function CarTable({ cars }: CarTableProps) {

    const [pagination, setPagination] = useState({
        pageIndex: 0,
        pageSize: 8,
    })
    const columns = useMemo<ColumnDef<CarDto>[]>(() => [
        {
            accessorKey: "id",
            header: "ID",
        },
        {
            accessorKey: "carModel",
            header: "Car model",
            cell: ({ row }) => row.original.carModel.name,
        },
        {
            accessorKey: "vin",
            header: "Vin",
        },
        {
            accessorKey: "color",
            header: "Color",
        },
        {
            accessorKey: "mileage",
            header: "Mileage",
        },
        {
            accessorKey: "yearManufacture",
            header: "Year of manufacture"
        },
        {
            accessorKey: "licensePlate",
            header: "License plate"
        },
        
    ], []);

    const table = useReactTable({
        data: cars,
        columns,
        getCoreRowModel: getCoreRowModel(),
        getPaginationRowModel: getPaginationRowModel(),
        state: {
            pagination
        },
        onPaginationChange: setPagination,
    });

    return (
        <div className="rounded-xl border shadow-sm">
            <Table>
                <TableHeader>
                    {table.getHeaderGroups().map(headerGroup => (
                        <TableRow key={headerGroup.id}>
                            {headerGroup.headers.map(header => (
                                <TableHead key={header.id} className="text-center" >
                                    {flexRender(header.column.columnDef.header, header.getContext())}
                                </TableHead>
                            ))}
                        </TableRow>
                    ))}
                </TableHeader>
                <TableBody>
                    {table.getRowModel().rows.map(row => (
                        <TableRow key={row.id}>
                            {row.getVisibleCells().map(cell => (
                                <TableCell key={cell.id}>
                                    {flexRender(cell.column.columnDef.cell, cell.getContext())}
                                </TableCell>
                            ))}
                        </TableRow>
                    ))}

                </TableBody>
            </Table>
            <div className="flex items-center gap-5 justify-center py-2  ">
                <Button
                    variant="outline"
                    size="sm"
                    onClick={() => table.previousPage()}
                    disabled={!table.getCanPreviousPage()}
                >
                    ‹  Previous
                </Button>
                <div className="text-sm text-muted-foreground">
                    Page {table.getState().pagination.pageIndex + 1} of {table.getPageCount()}
                </div>

                <Button
                    variant="outline"
                    size="sm"
                    onClick={() => table.nextPage()}
                    disabled={!table.getCanNextPage()}
                >
                    Next  ›
                </Button>
            </div>

        </div>
    )
}