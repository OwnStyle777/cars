
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { Label } from "./ui/label";
import { Input } from "./ui/input";
import { Button } from "./ui/button";
import {
  Select,
  SelectTrigger,
  SelectValue,
  SelectContent,
  SelectItem,
} from "@/components/ui/select";
import { CarModelApi, type CarModelDto } from "@/api/api";
import { useEffect, useState } from "react";

const carFormSchema = z.object({
  vin: z.string().min(1, "VIN is required"),
  color: z.string().min(1, "Color is required"),
  mileage: z.number().min(0, "Mileage must be equal or higher than 0"),
  yearManufacture: z.number().int().min(1900, "Insert valid year of manufacture"),
  licensePlate: z.string().min(1, "ŠPZ is required"),
  carModelId: z.string().min(1, "Car model is required"),
});

type CarFormProps = {
  defaultValues?: z.infer<typeof carFormSchema>;
  onSubmit: (data: z.infer<typeof carFormSchema>) => void;
};

export function CarForm({ defaultValues, onSubmit }: CarFormProps) {
  const [carModels, setCarModels] = useState<CarModelDto[]>([]);

  const {
    register,
    handleSubmit,
    setValue,
    watch,
    formState: { errors },
  } = useForm<z.infer<typeof carFormSchema>>({
    resolver: zodResolver(carFormSchema),
    defaultValues,
  });

  useEffect(() => {
    const fetchModels = async () => {
      const api = new CarModelApi();
      const response = await api.getAllCarModels();
      setCarModels(response.data);
    };

    fetchModels();
  }, []);

  const submitHandler = (data: z.infer<typeof carFormSchema>) => {
    onSubmit(data);
  };

  return (
    <form onSubmit={handleSubmit(submitHandler)}>
      <div>
        <Label htmlFor="vin">VIN</Label>
        <Input
          id="vin"
          {...register("vin")}
          placeholder="Enter VIN"
          aria-invalid={errors.vin ? "true" : "false"}
        />
        {errors.vin && (
          <p role="alert" className="text-red-600 text-sm mt-1">
            {errors.vin.message}
          </p>
        )}
      </div>

      <div>
        <Label htmlFor="color">Color</Label>
        <Input
          id="color"
          {...register("color")}
          placeholder="Enter color"
          aria-invalid={errors.color ? "true" : "false"}
        />
        {errors.color && (
          <p role="alert" className="text-red-600 text-sm mt-1">
            {errors.color.message}
          </p>
        )}
      </div>

      <div>
        <Label htmlFor="mileage">Mileage</Label>
        <Input
          id="mileage"
          type="number"
          {...register("mileage", { valueAsNumber: true })}
          placeholder="Enter mileage"
          aria-invalid={errors.mileage ? "true" : "false"}
        />
        {errors.mileage && (
          <p className="text-red-600 text-sm mt-1">
            {errors.mileage.message}
          </p>
        )}
      </div>

      <div>
        <Label htmlFor="yearManufacture">Year of Manufacture</Label>
        <Input
          id="yearManufacture"
          type="number"
          {...register("yearManufacture", { valueAsNumber: true })}
          placeholder="e.g. 2020"
          aria-invalid={errors.yearManufacture ? "true" : "false"}
        />
        {errors.yearManufacture && (
          <p className="text-red-600 text-sm mt-1">
            {errors.yearManufacture.message}
          </p>
        )}
      </div>

      <div>
        <Label htmlFor="licensePlate">License Plate</Label>
        <Input
          id="licensePlate"
          {...register("licensePlate")}
          placeholder="Enter license plate"
          aria-invalid={errors.licensePlate ? "true" : "false"}
        />
        {errors.licensePlate && (
          <p className="text-red-600 text-sm mt-1">
            {errors.licensePlate.message}
          </p>
        )}
      </div>

      <div>
        <Label htmlFor="carModelId">Car Model</Label>
        <Select
          value={watch("carModelId") || ""}
          onValueChange={(value) => setValue("carModelId", value)}
        >
          <SelectTrigger>
            <SelectValue placeholder="Select car model" />
          </SelectTrigger>
          <SelectContent>
            {carModels.map((model) => (
              <SelectItem key={model.id} value={String(model.id)}>
                {model.name}
              </SelectItem>
            ))}
          </SelectContent>
        </Select>
        {errors.carModelId && (
          <p className="text-red-600 text-sm mt-1">
            {errors.carModelId.message}
          </p>
        )}
      </div>

      <Button type="submit">Submit</Button>
    </form>
  );
}