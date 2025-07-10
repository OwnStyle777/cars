import { useEffect, useMemo, useState } from "react";
import { type BrandDto, type CarDto, BrandApi, CarApi } from "../api";
import { CarTable } from "./CarTable";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Search } from "lucide-react";
import { CarForm } from "./CarForm";
import { Dialog, DialogContent, DialogTitle } from "./ui/dialog";
import { DialogHeader } from "./ui/dialog";


export function CarDashboard() {
    const [brands, setBrands] = useState<BrandDto[]>([]);
    const [cars, setCars] = useState<CarDto[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<String | null>(null);
    const brandApi = new BrandApi();
    const carApi = new CarApi();
    const [showForm, setShowForm] = useState(false);


    useEffect(() => {
        setLoading(true);

        carApi.getAllCars()
            .then(response => { setCars(response.data) })
            .catch(err => { setError(err.response?.data?.error || err.message) })
            .finally(() => setLoading(false))

    }, []);


    if (loading) return <div>Loading...</div>
    if (error) return <div style={{ color: "red" }}>{error}</div>;

    return (
        <div className="p-6">
            <h1 className="text-3xl font-bold mb-5">Cars Dashboard</h1>
            <div className=" flex items-center gap-5 mb-5 ">
                <Button onClick={() => setShowForm(true)} >
                    Add new car
                </Button>
                <Dialog open={showForm} onOpenChange={setShowForm}>
                    <DialogContent className="max-w-xl">
                        <DialogHeader>
                            <DialogTitle>Add New Car</DialogTitle>
                        </DialogHeader>
                        <CarForm
                            onSubmit={(data) => {
                                console.log("Car data submitted:", data);
                                setShowForm(false);
                            }}

                        />
                    </DialogContent>
                </Dialog>
                <Search />
                <Input type="car model" placeholder="Search car model" />
            </div>
            <CarTable cars={cars} />
        </div>
    )

}