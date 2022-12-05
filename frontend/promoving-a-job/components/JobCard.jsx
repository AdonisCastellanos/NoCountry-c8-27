import Image from "next/image";

const JobCard = ({cardContent, cadImg}) => {
    return(
    <div>
        <div className="card" style={{width:"18rem"}}>
            <Image src={cadImg} className="card-img-top" alt="..." width={100} height={200}/>
            <div className="card-body">
                <p className="card-text">{cardContent}</p>
            </div>
        </div>
    </div>
    )
}

export default JobCard;
